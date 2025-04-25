package eu.gaiax.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.*;

import java.util.Map;

@ApiModel
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Statistics {
    @ApiModelProperty(name = "results", value = "Array of Statistics")
    @JsonProperty(value = "results", required = true)
    private Plot[] results;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Plot {
        @ApiModelProperty(name = "name", value = "Name of Plot")
        @JsonProperty(value = "name", required = true)
        private String name;
        @ApiModelProperty(name = "charts", value = "Values")
        @JsonProperty(value = "charts", required = true)
        private Chart[] charts;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Chart {
        @ApiModelProperty(name = "x", value = "Values in X-axis")
        @JsonProperty(value = "x", required = true)
        private String[] x;
        @ApiModelProperty(name = "y", value = "Values in Y-axis")
        @JsonProperty(value = "y", required = true)
        private double[] y;
        @ApiModelProperty(name = "type", value = "Type of chart")
        @JsonProperty(value = "type", required = true)
        private String type;
        @ApiModelProperty(name = "marker", value = "Properties")
        @JsonProperty(value = "marker", required = true)
        private Map<String, String> marker;
        @ApiModelProperty(name = "mode", value = "Mode of chart")
        @JsonProperty(value = "mode", required = true)
        private String mode;
        @ApiModelProperty(name = "showlegend", value = "Flag if legend should be shown")
        @JsonProperty(value = "showlegend", required = true)
        private boolean showlegend;
        @ApiModelProperty(name = "name", value = "Name of chart")
        @JsonProperty(value = "name", required = true)
        private String name;
    }
}
