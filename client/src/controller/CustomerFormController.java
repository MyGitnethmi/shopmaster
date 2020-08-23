package controller;

import com.jfoenix.controls.JFXButton;
import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
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

        observableList.clear();

        for (CustomerDTO d : allCustomers) {
            Button btn = new Button("Delete");
            observableList.add(new CustomerTM(d.getId(), d.getName(), d.getAddress(), d.getSalary(), btn));

            btn.setOnAction(e -> {


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Warning!");
                alert.setContentText("Are You sure whether You Want to delete this Customer?");

                ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.YES);
                ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);

                alert.getButtonTypes().setAll(ok, no);
                alert.showAndWait().ifPresent(buttonType -> {
                    if (buttonType == ButtonType.YES) {
                        try {
                            boolean isDeleted = service.deleteCustomer(d.getId());
                            if (isDeleted) {
                                loadAllCustomers();
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        //
                    }
                });


            });

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
            if (isSaved) {
                loadAllCustomers();
            }
        } else {
            //update
        }

    }
}
