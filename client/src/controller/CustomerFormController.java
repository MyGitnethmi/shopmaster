package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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

    public void Save_AndUpdate(ActionEvent actionEvent) {
    }
}
