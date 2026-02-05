import { useEffect, useState } from "react";
import { getAllUsers } from "../api/userApi";

function UserList() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    getAllUsers()
      .then(response => setUsers(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div>
      <h2>Users</h2>
      <ul>
        {users.map(user => (
          <li key={user.id}>
            {user.name} ({user.role})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default UserList;
