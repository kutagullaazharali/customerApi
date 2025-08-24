import React, { useState } from "react";
import "./LoginComp.css";

const LoginComponent = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const loginUser = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/v1/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password }), // <-- sending both email + password
      });

      if (!response.ok) throw new Error("Invalid email or password");

      const data = await response.json();
      localStorage.setItem("accessToken", data.accessToken);
      localStorage.setItem("refreshToken", data.refreshToken);

      setMessage("Login successful ✅");
    } catch (err) {
      setMessage(err.message);
    }
  };

  return (
    <div className="login-container">
      <div className="login-box">
        {/* Instagram Logo */}
        <h1 className="instagram-logo">Instagram</h1>

        {/* Email + Password */}
        <div className="form-group">
          <input
            type="email"
            placeholder="Phone number, username, or email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="input-box"
          />
          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className="input-box"
          />
          <button onClick={loginUser} className="login-btn">
            Log In
          </button>
        </div>

        {/* OR Divider */}
        <div className="divider">
          <div className="line"></div>
          <p>OR</p>
          <div className="line"></div>
        </div>

        {/* Facebook login */}
        <button className="facebook-login">Log in with Facebook</button>

        {/* Message */}
        {message && <p className="message">{message}</p>}
      </div>

      {/* Signup Box */}
      <div className="signup-box">
        <p>
          Don’t have an account? <a href="/signup">Sign up</a>
        </p>
      </div>
    </div>
  );
};

export default LoginComponent;
