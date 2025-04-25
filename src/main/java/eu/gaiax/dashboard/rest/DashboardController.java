package eu.gaiax.dashboard.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.gaiax.dashboard.model.*;
import eu.gaiax.dashboard.utils.ProxyCall;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/dashboard")
@ApiOperation("Dashboard Service")
public class DashboardController {

    @Autowired
    @Qualifier("demoSrv")
    WebClient srv;

    @Autowired
    @Qualifier("lcmSrv")
    WebClient lcm;

    @ApiOperation("Get News")
    @GetMapping("/news")
    public ResponseEntity<NewsResponse> getNews(HttpServletRequest request) {
        ResponseEntity<Map<String, ?>> re = ProxyCall.doProxyCall(srv, request, request.getRequestURI());
        if (re == null) return ResponseEntity.badRequest().build();
        Map<String, ?> rsObj = re.getBody();
        if (rsObj == null || rsObj.isEmpty()) return ResponseEntity.badRequest().build();
        ObjectMapper mapper = new ObjectMapper();
        NewsResponse rs = mapper.convertValue(rsObj, NewsResponse.class);
        return ResponseEntity.ok(rs);
    }

    @ApiOperation("Get Transactions")
    @GetMapping("/transactions")
    public ResponseEntity<TransactionResponse> getTransactions(HttpServletRequest request) {
        ResponseEntity<Map<String, ?>> re = ProxyCall.doProxyCall(lcm, request, "/api/lcm-service/transactions");
        if (re == null) return ResponseEntity.badRequest().build();
        Map<String, ?> rsObj = re.getBody();
        if (rsObj == null || rsObj.isEmpty()) return ResponseEntity.badRequest().build();
        ObjectMapper mapper = new ObjectMapper();
        TransactionResponse rs = mapper.convertValue(rsObj, TransactionResponse.class);
        return ResponseEntity.ok(rs);
    }

    @ApiOperation("Get Datasets")
    @GetMapping("/datasets")
    public ResponseEntity<DatasetResponse> getDatasets(HttpServletRequest request) {
        ResponseEntity<Map<String, ?>> re =
                ProxyCall.doProxyCall(lcm, request, "/api/lcm-service/datasets");
        if (re == null) return ResponseEntity.badRequest().build();
        Map<String, ?> rsObj = re.getBody();
        if (rsObj == null || rsObj.isEmpty()) return ResponseEntity.badRequest().build();
        ObjectMapper mapper = new ObjectMapper();
        DatasetResponse rs = mapper.convertValue(rsObj, DatasetResponse.class);
        return ResponseEntity.ok(rs);
    }

    @ApiOperation("Get Solution Packages")
    @GetMapping("/sp")
    public ResponseEntity<ServicesResponse> getSP(HttpServletRequest request) {
        ResponseEntity<Map<String, ?>> re =
                ProxyCall.doProxyCall(lcm, request, "/api/lcm-service/sp");
        if (re == null) return ResponseEntity.badRequest().build();
        Map<String, ?> rsObj = re.getBody();
        if (rsObj == null || rsObj.isEmpty()) return ResponseEntity.badRequest().build();
        ObjectMapper mapper = new ObjectMapper();
        ServicesResponse rs = mapper.convertValue(rsObj, ServicesResponse.class);
        return ResponseEntity.ok(rs);
    }

    @ApiOperation("Get Services")
    @GetMapping("/services")
    public ResponseEntity<ServicesResponse> getServices(HttpServletRequest request) {
        ResponseEntity<Map<String, ?>> re =
                ProxyCall.doProxyCall(lcm, request, "/api/lcm-service/services");
        if (re == null) return ResponseEntity.badRequest().build();
        Map<String, ?> rsObj = re.getBody();
        if (rsObj == null || rsObj.isEmpty()) return ResponseEntity.badRequest().build();
        ObjectMapper mapper = new ObjectMapper();
        ServicesResponse rs = mapper.convertValue(rsObj, ServicesResponse.class);
        return ResponseEntity.ok(rs);
    }

    @ApiOperation("Get Statistics")
    @GetMapping("/statistics")
    public ResponseEntity<Statistics> getStatistics(HttpServletRequest request) {
        ResponseEntity<Map<String, ?>> re =
                ProxyCall.doProxyCall(lcm, request, "/api/lcm-service/statistics");
        if (re == null) return ResponseEntity.badRequest().build();
        Map<String, ?> rsObj = re.getBody();
        if (rsObj == null || rsObj.isEmpty()) return ResponseEntity.badRequest().build();
        ObjectMapper mapper = new ObjectMapper();
        Statistics plots = mapper.convertValue(rsObj, Statistics.class);
        return ResponseEntity.ok(plots);
    }

    @ApiOperation("Update Status of Datasets / Solution Packages / Services")
    @PostMapping(value = {"/datasets", "/sp", "/services"})
    public ResponseEntity<?> activate(HttpServletRequest request, @RequestBody ActivateRq rq) {
        return ProxyCall.doPost(srv, request, rq);
    }

}
