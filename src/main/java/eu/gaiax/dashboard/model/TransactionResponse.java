package eu.gaiax.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@ApiModel
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionResponse {
    @ApiModelProperty(name = "results", value = "Array of Transactions")
    @JsonProperty(value = "results", required = true)
    private List<TransactionItem> data;
}
