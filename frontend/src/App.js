import './App.css'
import React from 'react'
// import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import HeaderComponent from './component/HeaderComponent'
import FooterComponent from './component/FooterComponent'
// import {  Route, Routes } from "react-router-dom";
//  import ListEmployeeComponent from './component/ListEmployeeComponent'
//  import CreateEmployeeComponent from './component/CreateEmployeeComponent'
//  import ViewEmployeeComponent from './component/ViewEmployeeComponent'


function App() {
  return (
    <div>
       <HeaderComponent />
       {/* <Routes>
            <Route path="/" element={ListEmployeeComponent}></Route>
            <Route path="/employees" element={ListEmployeeComponent}></Route>
            <Route
              path="/add-employee/:id"
              element={CreateEmployeeComponent}
            ></Route>
            <Route
              path="/view-employee/:id"
              element={ViewEmployeeComponent}
            ></Route>
      </Routes>  */}
      <FooterComponent />
    </div>
  )
}


export default App
