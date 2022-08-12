package kemy.dev.InterceptorExample2.controllers;

import kemy.dev.InterceptorExample2.entities.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/*MonthController that:
is mapped on months
returns a Month using a specific request attribute
 */
@RestController
@RequestMapping("/month")

public class MonthController {

    @GetMapping("")

    public Month months(HttpServletRequest request){
        Month month=(Month) request.getAttribute("Month interceptor-month");
        return month;
    }
}
