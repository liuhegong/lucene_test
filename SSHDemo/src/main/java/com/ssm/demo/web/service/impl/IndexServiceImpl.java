package com.ssm.demo.web.service.impl;

import com.ssm.demo.core.constants.MyConstant;
import com.ssm.demo.core.dto.DocDto;
import com.ssm.demo.core.util.MyFileUtil;
import com.ssm.demo.web.service.IndexService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.ssm.demo.core.util.MyFileUtil.*;

/**
 * Describe: description of this class
 * Author: ouym
 * Created Date: 2016/11/30.
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {

    public boolean createIndex(String path) {
        Date date1 = new Date();
        List<File> fileList = getFileList(path);
        File indexFile = new File(MyConstant.INDEX_PATH);
        //避免重复索引
        if (indexFile.exists()){
            MyFileUtil.deleteDir(indexFile);
        }else {
            indexFile.mkdirs();
        }
        String content="";
        Analyzer analyzer = null;
        Directory directory = null;
        IndexWriter indexWriter = null;

        for (File file : fileList) {
            content = "";
            //获取文件后缀
            String type = file.getName().substring(file.getName().lastIndexOf(".")+1);
            if("txt".equalsIgnoreCase(type)){
                content += txt2String(file);
            }else if("doc".equalsIgnoreCase(type)){
                content += doc2String(file);
            }else if("xls".equalsIgnoreCase(type)){
                content += xls2String(file);
            }

            try{
                //lucene的中文分词器
                //analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);

                //使用第三方中文分词器IKAnalyzer
                analyzer = new IKAnalyzer(true);
                directory = FSDirectory.open(new File(MyConstant.INDEX_PATH));
                IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_CURRENT,analyzer);
                indexWriter = new IndexWriter(directory, config);

                Document document = new Document();
                document.add(new TextField("filename", file.getName(), Field.Store.YES));
                document.add(new TextField("content", content, Field.Store.YES));
                document.add(new TextField("path", file.getPath(), Field.Store.YES));
                indexWriter.addDocument(document);
                indexWriter.commit();
                indexWriter.close();

            }catch(Exception e){
                e.printStackTrace();
            }
            content = "";
        }
        Date date2 = new Date();
        System.out.println("创建索引-----耗时：" + (date2.getTime() - date1.getTime()) + "ms\n");
        return false;
    }

    public List<DocDto> searchIndex(String queryStr,Model model) {

        Date date1 = new Date();
        Analyzer analyzer = null;
        Directory directory = null;
        IndexWriter indexWriter = null;
        String prefixHTML = "<font color='red'>";
        String suffixHTML = "</font>";
        List<DocDto> docDtoList = new ArrayList<>();
        try{
            directory = FSDirectory.open(new File(MyConstant.INDEX_PATH));
            //analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
            analyzer = new IKAnalyzer(true);
            DirectoryReader ireader = DirectoryReader.open(directory);
            IndexSearcher isearcher = new IndexSearcher(ireader);

            QueryParser parser = new QueryParser(Version.LUCENE_CURRENT,"content", analyzer);
            Query query = parser.parse(queryStr);

            ScoreDoc[] hits = isearcher.search(query, null, 10).scoreDocs;
            //ScoreDoc[] hits = isearcher.search(query, 10).scoreDocs;

            for (int i = 0; i < hits.length; i++) {
                DocDto docDto = new DocDto();
                Document hitDoc = isearcher.doc(hits[i].doc);
                //自动摘要，查询关键词高亮
                SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter(prefixHTML, suffixHTML);
                Highlighter highlighter = new Highlighter(simpleHTMLFormatter,new QueryScorer(query));
                String highLightText = highlighter.getBestFragment(analyzer,"content",hitDoc.get("content"));

                docDto.setDocName(hitDoc.get("filename"));
                String path = hitDoc.get("path");
                path = path.replaceAll("\\\\", "/");
                docDto.setDocPath(path);
                docDto.setDocAbstract(highLightText+"...");
                docDtoList.add(docDto);
            }
            ireader.close();
            directory.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        Date date2 = new Date();
        //System.out.println("查看索引-----耗时：" + (date2.getTime() - date1.getTime()) + "ms\n");
        model.addAttribute("spendTimes",(date2.getTime() - date1.getTime()));
        return docDtoList;
    }
}
