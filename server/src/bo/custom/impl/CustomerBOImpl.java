package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DaoFactory;
import dao.custom.CustomerDao;
import db.HibernateUtil;
import dto.CustomerDTO;
import entity.Customer;
import org.hibernate.Session;

import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    /*CustomerDao dao=new CustomerDaoImpl();*/
    CustomerDao dao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSession(session);
            session.beginTransaction();
            boolean isSaved = dao.save(
                    new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary())
            );
            session.getTransaction().commit();
            return isSaved;

        }

    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {

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
