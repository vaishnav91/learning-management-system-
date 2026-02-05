import CreateUser from "./components/CreateUser";
import UserList from "./components/UserList";
import CreateCourse from "./components/CreateCourse";
import CourseList from "./components/CourseList";

function App() {
  return (
    <div>
      <h1>LMS Frontend</h1>

      <CreateUser />
      <UserList />

      <hr />

      <CreateCourse />
      <CourseList />
    </div>
  );
}

export default App;
