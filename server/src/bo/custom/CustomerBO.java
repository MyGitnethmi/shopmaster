package bo.custom;

import bo.SuperBo;
import dto.CustomerDTO;

import java.util.List;

public interface CustomerBO extends SuperBo {
    public boolean saveCustomer(CustomerDTO dto) throws Exception;

    public boolean updateCustomer(CustomerDTO dto) throws Exception;

    public boolean deleteCustomer(String id) throws Exception;

    public CustomerDTO getCustomer(String id) throws Exception;

    public List<CustomerDTO> getAllCustomers() throws Exception;
}
