package org.donstu;

import org.donstu.client.Company;
import org.donstu.client.HhService;
import org.donstu.client.HhService_Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ServiceClient {
    private static final QName FQDN = new QName("https://donstu.org/hh", "HhService");

    private static URL getWsdlUrl(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return url;
    }

    public void processCompanyList(URL url) {
        HhService_Service svc = new HhService_Service(url, FQDN);
        HhService port = svc.getHhPort();
        List<Company> companies = port.getCompanyList();
        companies.forEach(company -> System.out.println("Company{" +
                "name='" + company.getName() + '\'' +
                ", description='" + company.getDescription() + '\'' +
                ", address='" + company.getAddress() + '\'' +
                ", phone='" + company.getPhoneNumber() + '\'' +
                '}'));
    }

    public static void main(String[] args) {
        URL wsdlUrl = getWsdlUrl("http://127.0.0.1:8088/hh?wsdl");
        ServiceClient client = new ServiceClient();
        client.processCompanyList(wsdlUrl);
    }
}
