package service.custom;

import dto.CustomerDTO;
import service.SuperService;

import java.util.List;

public interface CustomerService extends SuperService {

    public boolean saveCustomer(CustomerDTO dto) throws Exception;

    public boolean updateCustomer(CustomerDTO dto) throws Exception;

    public boolean deleteCustomer(String id) throws Exception;

    public CustomerDTO getCustomer(String id) throws Exception;

    public List<CustomerDTO> getAllCustomers() throws Exception;

}
