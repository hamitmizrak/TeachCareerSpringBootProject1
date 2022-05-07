import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService'

class ListEmployeeComponent extends Component {
  //constructro
  constructor(props) {
    //kalıtımladığımızda
    super(props)

    //durum degiskeni
    this.state = {
      employee: [],
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
    this.props.history.push(`/add-employee/${id}`)
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
            <button className="btn btn-primary" onClick={this.addEmployee}>
              Ekleme
            </button>
          </div>

          <div className="row mb-3">
            <table>
              <thead>
                <tr>
                  <th>Müşteri ID</th>
                  <th>Müşteri Adı</th>
                  <th>Müşteri Email</th>
                  <th>Button</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>employeeId</td>
                  <td>employeeName</td>
                  <td>employeeEmail</td>

                  <td>
                    <button className="btn btn-success">Güncelle</button>
                    <button className="btn btn-primary">Göster</button>
                    <button className="btn btn-danger">Sil</button>
                  </td>
                </tr>
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
