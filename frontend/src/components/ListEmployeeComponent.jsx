import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService'

class ListEmployeeComponent extends Component {
  //constructro
  constructor(props) {
    //kalıtımladığımızda
    super(props)

    //durum degiskeni
    this.state = {
      employees: [],
    }

    //bind
    this.addEmployee = this.addEmployee.bind(this)
    this.editEmployee = this.editEmployee.bind(this)
    this.deleteEmployee = this.deleteEmployee.bind(this)
  }

  //BUTON Add Router Link
  addEmployee() {
    this.props.history.push('/add-employee/_add')
  }

  //View Sayfasına gidecek
  viewEmployee(id) {
    this.props.history.push(`/view-employee/${id}`);
  }

  //Güncelleme Sayfasına gidecek
  editEmployee(id) {
    this.props.history.push(`/add-employee/${id}`)
  }

  //Delete
  deleteEmployee(id) {
    EmployeeService.deleteEmployee(id).then((res) => {
      this.setState({
        employees: this.state.employees.filter(
          (employee) => employee.id !== id,
        ),
      })
    })
  }

  //didmount
  //cdm ==>TAB :service hazırlamak için
  componentDidMount() {
    console.log('did mount çalıştı')
    EmployeeService.getEmployees().then((res) => {
      this.setState({ employees: res.data })
    })
  }

  render() {
    return (
      <div>
        <h3 className="text-danger">Listem</h3>
        <div className="container">
          <div className="row mb-3">
            <button className="btn btn-primary btn-dm" onClick={this.addEmployee}>
              Ekleme
            </button>
          </div>

          <div className="row mb-3">
            <table className="table table-striped table-hover table-bordered">
              <thead>
                <tr>
                  <th>Müşteri ID</th>
                  <th>Müşteri Adı</th>
                  <th>Müşteri Email</th>
                  <th>Button</th>
                </tr>
              </thead>
              <tbody>
                {this.state.employees.map((employee) => (
                  <tr key={employee.employeeId}>
                    <td>{employee.employeeId}</td>
                    <td>{employee.employeeName}</td>
                    <td>{employee.employeeEmail}</td>

                    <td>
                      <button onClick={()=>this.updateEmployee(employee.employeeId)}  className="btn btn-success">Güncelle</button>
                      <button onClick={()=>this.viewEmployee(employee.employeeId)} style={{marginLeft:"10px"}} className="btn btn-primary">Göster</button>
                      <button onClick={()=>this.deleteEmployee(employee.employeeId)}  className="btn btn-danger" style={{marginLeft:"10px"}}>Sil</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
      </div>
    )
  }
}

export default ListEmployeeComponent
