package org.donstu.handler;

import org.donstu.async.Company;
import org.donstu.async.GetCompanyListResponse;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class HhAsyncHandler implements AsyncHandler<GetCompanyListResponse> {
    private GetCompanyListResponse response;
    @Override
    public void handleResponse(Response<GetCompanyListResponse> res) {
        System.out.println("Result is ready!");
        try {
            response = res.get();
            List<Company> companies = response.getReturn();
            companies.forEach(company -> System.out.println("Company{" +
                    "name='" + company.getName() + '\'' +
                    ", description='" + company.getDescription() + '\'' +
                    ", address='" + company.getAddress() + '\'' +
                    ", phone='" + company.getPhoneNumber() + '\'' +
                    '}'));
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
