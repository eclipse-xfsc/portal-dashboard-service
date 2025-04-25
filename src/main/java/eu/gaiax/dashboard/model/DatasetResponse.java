package eu.gaiax.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.*;

import java.util.List;

@ApiModel
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DatasetResponse {
    @ApiParam(name = "results", value = "Array of datasets")
    @JsonProperty(value = "results", required = true)
    private List<DatasetItem> data;
}
