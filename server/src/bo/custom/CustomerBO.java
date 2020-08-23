package bo.custom;

import bo.SuperBo;
import dto.CustomerDTO;

public interface CustomerBO extends SuperBo {
    public boolean saveCustomer(CustomerDTO dto) throws Exception;

    public boolean updateCustomer(CustomerDTO dto) throws Exception;

    public boolean deleteCustomer(String id) throws Exception;

    public boolean getCustomer(String id) throws Exception;

    public boolean getAllCustomers() throws Exception;
}
