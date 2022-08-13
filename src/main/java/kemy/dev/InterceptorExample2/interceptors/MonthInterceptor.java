package kemy.dev.InterceptorExample2.interceptors;

import kemy.dev.InterceptorExample2.entities.Month;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*has an interceptor/middleware called MonthInterceptor that:
has a list of 6 Months
takes the header monthNumber from the request
if monthNumber is null/empty then returns an HTTP Bad Request error
else:
looks if the passed monthNumber is present in the list
if present, returns it using a specific request attribute
else, returns an empty Month with all the string values set to nope
returns an HTTP OK status

 */
@Component
public class MonthInterceptor implements HandlerInterceptor{

    public static List<Month> monthList=new ArrayList<>(Arrays.asList(

            new Month(1,"January","Gennaio","Januar"),
            new Month(2,"February","Febbraio","Februar"),
            new Month(3,"March","Marzo","März"),
            new Month(4,"April","Aprile","April "),
            new Month(5,"May","Maggio","Mai "),
            new Month(6,"June","Giugno","Juni ")

    ));
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String stringMonthNumber=request.getHeader("monthNumber");
        System.out.println("inizio il prehandle");
        //se l'header viene disabilitato o se il campo è vuoto
        if (stringMonthNumber==null||stringMonthNumber.isEmpty()){
            System.out.println("monthnumber is null or empty, abilita L'header monthNumber");
            response.setStatus(400);
            //return true;
        }
        int monthNumber=Integer.parseInt(stringMonthNumber);
        Optional<Month> month=monthList.stream().filter(singleMonth -> singleMonth.getMonthNumber()==monthNumber).findAny();
       if(month.isEmpty()){
           System.out.println("month is empty");
            //returns an empty Month with all the string values set to nope
            request.setAttribute("Month interceptor-month",
                    new Month(0,"nope","nope","nope"));
        }
       if(month.isPresent()){
        System.out.println("month number " + monthNumber + " is present!");
        request.setAttribute("Month interceptor-month", month.get());}
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
