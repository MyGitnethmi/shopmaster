package controller;

import com.jfoenix.controls.JFXButton;
import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import proxy.ProxyHandler;
import service.ServiceFactory;
import service.custom.CustomerService;
import view.tm.CustomerTM;

import java.util.List;

public class CustomerFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtSalary;
    public TextField txtAddress;
    public JFXButton btnSave;
    public TextField txtSearch;
    public TableView<CustomerTM> tbl;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colOperate;

    public void initialize() throws Exception {
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory("salary"));
        colOperate.setCellValueFactory(new PropertyValueFactory("button"));
        loadAllCustomers();
    }

    private void loadAllCustomers() throws Exception {
        CustomerService service = ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
        List<CustomerDTO> allCustomers = service.getAllCustomers();
        ObservableList<CustomerTM> observableList = FXCollections.observableArrayList();

        for (CustomerDTO d : allCustomers) {
            Button btn = new Button("Delete");
            observableList.add(new CustomerTM(d.getId(), d.getName(), d.getAddress(), d.getSalary(), btn));
        }
        tbl.setItems(observableList);
    }


    public void Save_AndUpdate(ActionEvent actionEvent) throws Exception {
        if (btnSave.getText().equalsIgnoreCase("Save Customer")) {

            CustomerDTO dto = new CustomerDTO(
                    txtId.getText(), txtName.getText(), txtAddress.getText(), Double.parseDouble(txtSalary.getText())
            );

            CustomerService service = ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
            boolean isSaved = service.saveCustomer(dto);
            System.out.println(isSaved);
        } else {
            //update
        }

    }
}
