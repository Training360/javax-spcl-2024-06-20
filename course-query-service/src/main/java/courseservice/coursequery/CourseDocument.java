package courseservice.coursequery;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "courses")
public class CourseDocument {

    private Long id;

    private String name;

    private String description;

    private String syllabus;

}
