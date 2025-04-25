package eu.gaiax.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatisticsResponse {
    @ApiModelProperty(name = "total", value = "Total count")
    @JsonProperty(value = "total", required = true)
    private int total;
    @ApiModelProperty(name = "results", value = "Array of Statistics")
    @JsonProperty(value = "date_from", required = true)
    private String dateFrom;
    @ApiModelProperty(name = "results", value = "Array of Statistics")
    @JsonProperty(value = "date_to", required = true)
    private String dateTo;
    @ApiModelProperty(name = "results", value = "Array of Statistics")
    @JsonProperty(value = "transactions", required = true)
    private List<Transaction> transactions;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Transaction {
        @ApiModelProperty(name = "results", value = "Array of Statistics")
        @JsonProperty(value = "id", required = true)
        private int id;
        @ApiModelProperty(name = "results", value = "Array of Statistics")
        @JsonProperty(value = "date", required = true)
        private String date;
    }
}
