package kemy.dev.InterceptorExample2.entities;

import lombok.*;

/*
write a Spring Boot application with the necessary dependencies that:
works with an entity Month that has the following attributes:
an int monthNumber
an englishName
an italianName
a germanName
has 2 controllers:
BasicController that:
welcomes the user on the root mapping
MonthController that:
is mapped on months
returns a Month using a specific request attribute
has an interceptor/middleware called MonthInterceptor that:
has a list of 6 Months
takes the header monthNumber from the request
if monthNumber is null/empty then returns an HTTP Bad Request error
else:
looks if the passed monthNumber is present in the list
if present, returns it using a specific request attribute
else, returns an empty Month with all the string values set to nope
returns an HTTP OK status
test the endpoint call using Postman and considering at least 4 cases:
the header monthNumber is absent
the header monthNumber is empty
the header monthNumber has a value that is in the list
the header monthNumber has a value that is not in the list

 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Month {

    private int monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;

}
