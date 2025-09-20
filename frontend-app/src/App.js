import React from "react";
import { Routes, Route } from "react-router-dom";
import LoginComponent from "./loginComponent";
import SignUpForm from "./SignUp";

function App() {
  return (
    <Routes>
      <Route path="/" element={<LoginComponent />} />
      <Route path="/login" element={<LoginComponent />} />
      <Route path="/signup" element={<SignUpForm />} />
    </Routes>
  );
}

export default App;
