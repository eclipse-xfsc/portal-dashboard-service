package eu.gaiax.dashboard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiParam;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DatasetItem {
    @ApiParam(name = "id", value = "ID of dataset", example = "aw3f34kk3k45k45")
    @JsonProperty(value = "id", required = true)
    private String id;
    @ApiParam(name = "name", value = "Name of dataset", example = "Ansible")
    @JsonProperty(value = "name", required = true)
    private String name;
    @ApiParam(name = "preview_img", value = "Preview image URL", example = "http://preview.img")
    @JsonProperty(value = "preview_img", required = true)
    private String previewImg;
    @ApiParam(name = "provider_url", value = "Provider URL", example = "http://provider.url")
    @JsonProperty(value = "provider_url", required = true)
    private String providerUrl;
    @ApiParam(name = "logo", value = "Logo Image URL", example = "http://logo.img")
    @JsonProperty(value = "logo", required = true)
    private String logo;
    @ApiParam(name = "description", value = "Description", example = "One two three")
    @JsonProperty(value = "description", required = true)
    private String description;
    @ApiParam(name = "is_activated", value = "Flag if dataset is activated", example = "false")
    @JsonProperty(value = "is_activated", required = true)
    private boolean isActivated;
    @ApiParam(name = "is_own", value = "Flag if current user owns this dataset", example = "false")
    @JsonProperty(value = "is_own", required = true)
    private boolean isOwn;
    @ApiParam(name = "status", value = "Status of dataset", example = "undeployed", allowableValues = "null, deploying, deployed, undeploying, undeployed")
    @JsonProperty(value = "status", required = true)
    private String status;
}
