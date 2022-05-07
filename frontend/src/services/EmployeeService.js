import axios from 'axios'

const EMPLOYEE_API_BASE_URL = 'http://localhost:8080/api/v1/employees'

class EmployeeService {
  //LISTE: parametresiz return
  getEmployees() {
    return axios.get(EMPLOYEE_API_BASE_URL)
  }

  //FIND
  getEmployeeById(employeeId) {
    return axios.get(EMPLOYEE_API_BASE_URL + '/' + employeeId)
  }

  //CREATE
  createEmployee(employee) {
    return axios.post(EMPLOYEE_API_BASE_URL, employee)
  }

  //UPDATE
  updateEmployee(employee, employeeId) {
    return axios.put(EMPLOYEE_API_BASE_URL + '/' + employeeId, employee)
  }
  //DELETE
  deleteEmployee(employeeId) {
    return axios.get(EMPLOYEE_API_BASE_URL + '/' + employeeId)
  }
}

export default new EmployeeService()
