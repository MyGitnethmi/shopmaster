package controller;

import com.jfoenix.controls.JFXButton;
import dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import proxy.ProxyHandler;
import service.ServiceFactory;
import service.custom.CustomerService;

public class CustomerFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtSalary;
    public TextField txtAddress;
    public JFXButton btnSave;
    public TextField txtSearch;
    public TableView tbl;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colOperate;

    public void Save_AndUpdate(ActionEvent actionEvent) throws Exception {

        if (btnSave.getText().equalsIgnoreCase("Save Customer")) {

            CustomerDTO dto = new CustomerDTO(
                    txtId.getText(), txtName.getText(), txtAddress.getText(), Double.parseDouble(txtSalary.getText())
            );

            CustomerService service = ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
            boolean isSaved = service.saveCustomer(dto);
            System.out.println(isSaved);

            // save
        } else {
            //update
        }

    }
}
