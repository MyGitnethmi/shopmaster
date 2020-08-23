package bo.custom.impl;

import bo.custom.CustomerBO;
import dto.CustomerDTO;

import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    /*CustomerDao dao=new CustomerDaoImpl();*/

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return false;
    }

    @Override
    public CustomerDTO getCustomer(String id) throws Exception {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return null;
    }
}
