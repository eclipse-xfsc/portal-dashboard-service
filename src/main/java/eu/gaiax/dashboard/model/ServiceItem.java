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
public class ServiceItem {
    @ApiModelProperty(name = "id", value = "Internal service ID")
    @JsonProperty(value = "id", required = true)
    private String id;
    @ApiModelProperty(name = "name", value = "Name of the Service")
    @JsonProperty(value = "name", required = true)
    private String name;
    @ApiModelProperty(name = "preview_img", value = "Preview Image link")
    @JsonProperty(value = "preview_img", required = true)
    private String previewImg;
    @ApiModelProperty(name = "provider_url", value = "Provider URL")
    @JsonProperty(value = "provider_url", required = true)
    private String providerUrl;
    @ApiModelProperty(name = "logo", value = "Logo image link")
    @JsonProperty(value = "logo", required = true)
    private String logo;
    @ApiModelProperty(name = "description", value = "Description")
    @JsonProperty(value = "description", required = true)
    private String description;
    @ApiModelProperty(name = "is_activated", value = "Flag if services was activated")
    @JsonProperty(value = "is_activated", required = true)
    private boolean isActivated;
    @ApiModelProperty(name = "is_own", value = "Flag if user owns the service")
    @JsonProperty(value = "is_own", required = true)
    private boolean isOwn;
    @ApiModelProperty(name = "status", value = "Status of the services", allowableValues = "no status, deploying, deployed, undeploying, undeployed")
    @JsonProperty(value = "status", required = true)
    private String status;
}
