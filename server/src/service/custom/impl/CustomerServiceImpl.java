package service.custom.impl;

import bo.BoFactory;
import bo.custom.CustomerBO;
import dto.CustomerDTO;
import service.custom.CustomerService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {


    public CustomerServiceImpl() throws RemoteException {

    }

    CustomerBO bo = BoFactory.getInstance().getBo(BoFactory.BoType.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        return bo.saveCustomer(dto);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return bo.updateCustomer(dto);
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return bo.deleteCustomer(id);
    }

    @Override
    public CustomerDTO getCustomer(String id) throws Exception {
        return bo.getCustomer(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return bo.getAllCustomers();
    }
}
