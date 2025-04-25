package eu.gaiax.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewsItem {
    @ApiModelProperty(name = "id", value = "News ID")
    @JsonProperty(value = "id", required = true)
    private String id;
    @ApiModelProperty(name = "title", value = "Title of News")
    @JsonProperty(value = "title", required = true)
    private String title;
    @ApiModelProperty(name = "subtitle", value = "Subtitle")
    @JsonProperty(value = "subtitle", required = true)
    private String subtitle;
    @ApiModelProperty(name = "date", value = "Date")
    @JsonProperty(value = "date", required = true)
    private String date;
}
