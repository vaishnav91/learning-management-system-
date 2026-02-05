import { useState } from "react";
import { createUser } from "../api/userApi";

function CreateUser() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState("STUDENT");
  const [message, setMessage] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    const userData = {
      name,
      email,
      password,
      role
    };

    createUser(userData)
      .then(() => {
        setMessage("User created successfully");
        setName("");
        setEmail("");
        setPassword("");
        setRole("STUDENT");
      })
      .catch(() => {
        setMessage("Error creating user");
      });
  };

  return (
    <div>
      <h2>Create User</h2>

      <form onSubmit={handleSubmit}>
        <div>
          <input
            type="text"
            placeholder="Name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>

        <div>
          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>

        <div>
          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>

        <div>
          <select value={role} onChange={(e) => setRole(e.target.value)}>
            <option value="STUDENT">STUDENT</option>
            <option value="INSTRUCTOR">INSTRUCTOR</option>
            <option value="ADMIN">ADMIN</option>
          </select>
        </div>

        <button type="submit">Create User</button>
      </form>

      {message && <p>{message}</p>}
    </div>
  );
}

export default CreateUser;
