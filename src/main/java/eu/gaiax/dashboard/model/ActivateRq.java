package eu.gaiax.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.*;

@ApiModel("Request to (de)activate service/solution package/dataset")
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActivateRq {
    @ApiParam(name = "id", value = "ID of Item", example = "aw3f34kk3k45k45")
    @JsonProperty(value = "id", required = true)
    private String id;
    @ApiParam(name = "is_activated", value = "Flag if item is activated", example = "false")
    @JsonProperty(value = "is_activated", required = true)
    private boolean isActivated;
}
