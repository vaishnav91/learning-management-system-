import { useEffect, useState } from "react";
import { getAllCourses } from "../api/courseApi";

function CourseList() {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    getAllCourses()
      .then((res) => setCourses(res.data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <div>
      <h2>Courses</h2>
      <ul>
        {courses.map((course) => (
          <li key={course.id}>
            <strong>{course.title}</strong> — {course.instructorName}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CourseList;
