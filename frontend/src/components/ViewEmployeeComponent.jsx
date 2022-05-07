import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService'

export default class ViewEmployeeComponent extends Component {
  constructor(props) {
    super(props)
    this.state = {
      //gelen id almak
      id: this.props.match.params.id,
      employee: {},
    }
  }

  //cdm
  componentDidMount() {
    EmployeeService.getEmployeeById(this.state.id).then((res) => {
      this.setState({ employee: res.data })
    })
  }

  render() {
    return (
      <>
        <div className="card text-center mt-5">
          <div className="card-header">
            <i className="fa-solid fa-people-group"></i> My Profile
            <img className="card-img-top" src="deneme.jpg" alt="TechCareer" />
          </div>
          <div className="card-body">
            <h5 className="card-title">{this.state.employee.employeeId}</h5>
            <p className="card-text">{this.state.employee.employeeName}</p>
            <p className="card-text ">
             
              <i className="fa-solid fa-envelopes-bulk text-primary"></i>{' '}
              {this.state.employee.employeeEmail}
            </p>
            <p
              className="card-text text-capitalize"
              style={{ textAlign: 'justify' }}
            >
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo ad
              voluptatibus repellat fugit cumque et quibusdam facilis, animi
              dolorum adipisci tempora odit temporibus reprehenderit ipsum
              architecto aliquid iure, exercitationem assumenda! Temporibus esse
              fugit officia, accusantium quibusdam labore, inventore magni dolor
              blanditiis ipsum unde tempore fugiat, ex perspiciatis magnam
              similique dignissimos. Et in necessitatibus deleniti id dolore
              aperiam, explicabo eius nostrum? Omnis aperiam officia quas,
              molestias at illo aut dolores culpa repellat consequatur modi
              quasi perspiciatis perferendis ut fugit sit totam amet nulla
              beatae alias necessitatibus. Quas similique possimus nulla
              perferendis! Natus, officiis veritatis! Exercitationem quod fugit
              deserunt quae dignissimos repellat facilis expedita, sed quam.
              Est, delectus dicta odio voluptatibus nisi rem inventore.
              Asperiores consectetur eligendi iure? Sint quos id enim!
              Asperiores placeat enim officiis recusandae, possimus, nisi
              provident porro repellendus dolorem voluptas saepe officia vel
              nam. Quasi eum magnam delectus consectetur voluptate tenetur
              molestiae sit excepturi accusantium. Ipsum, aperiam consectetur.
              Asperiores, porro. Repudiandae eligendi voluptatibus iure dolor ut
              vero ea inventore maxime cupiditate? Vel esse, accusantium
              deserunt dolorum corporis ullam nesciunt unde quos magnam
              officiis? Tenetur cum nam eius labore? Harum, et adipisci dicta
              iure voluptate debitis quod dolor dolorem cum eum fuga,
              consequuntur repellat dolorum laboriosam inventore laudantium
              dolores natus ratione, iste itaque? Sequi atque accusamus vel
              nihil obcaecati. Placeat debitis, officia officiis aliquam cumque
              voluptates dicta. Iure eligendi reiciendis mollitia quod
              laboriosam accusamus ex facere iusto accusantium tempora
              consequuntur voluptatum, at labore in doloremque quos fugit eum.
              Ut. Eaque, beatae, maiores, debitis distinctio perferendis nihil
              repudiandae quas repellendus nostrum minima quisquam earum error
              exercitationem facere voluptate eveniet sapiente ullam?
              Repudiandae perspiciatis a quis in maiores, animi fugiat.
              Quibusdam. Delectus esse perferendis optio reiciendis aspernatur
              praesentium, est quis omnis laboriosam aut? Consequuntur expedita
              eveniet est nobis, accusantium eum excepturi nulla temporibus aut
              facere incidunt qui, officiis ut repudiandae quis.
            </p>
            <a href="#" class="btn btn-primary">
              Go somewhere
            </a>
          </div>
          <div className="card-footer text-muted">2 days ago</div>
        </div>
      </>
    )
  }
}
