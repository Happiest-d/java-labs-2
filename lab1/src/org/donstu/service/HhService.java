package org.donstu.service;

import org.donstu.domain.Company;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

import static javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED;
import static javax.jws.soap.SOAPBinding.Style.DOCUMENT;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

@WebService(serviceName = "HhService", portName = "HhPort",
    targetNamespace = "https://donstu.org/hh")
@SOAPBinding(style = DOCUMENT, use = LITERAL, parameterStyle = WRAPPED)
public class HhService {

    @WebMethod(operationName = "getCompanyList")
    public List<Company> getCompanyList() {
        List<Company> result = new ArrayList<>();
        result.add(new Company("Google", "Best Search Engine", "Mountain View, CA 94043", "+1 650-253-0000"));
        result.add(new Company("Apple", "Apple Inc.", "Cupertino, CA 95014", "+1 408-996-1010"));
        result.add(new Company("Microsoft", "Microsoft Corporation", "Redmond, WA 98052", "+1 425-882-8080"));
        result.add(new Company("Samsung", "Samsung Electronics", "Seoul, Korea", "+82 2 1234 5678"));
        result.add(new Company("Nokia", "Nokia Corporation", "Helsinki, Finland", "+358 9 123 4567"));
        result.add(new Company("Sony", "Sony Corporation", "Tokyo, Japan", "+81 3 1234 5678"));
        result.add(new Company("Yandex", "Yandex LLC", "Moscow, Russia", "+7 499 123 45 67"));
        return result;
    }
}
