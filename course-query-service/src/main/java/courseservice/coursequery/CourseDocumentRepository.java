package courseservice.coursequery;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CourseDocumentRepository extends ElasticsearchRepository<CourseDocument, Long> {

    // language=json
    @Query("""
        {
        "multi_match": {
            "query": "?0",
            "fields": ["name", "description", "syllabus"]
        }
        }
    """)
    List<CourseDocument> findByWord(String word);
}
