import { useState } from "react";
import { createCourse } from "../api/courseApi";

function CreateCourse() {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [instructorName, setInstructorName] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    const courseData = {
      title,
      description,
      instructorName,
    };

    createCourse(courseData)
      .then(() => {
        setMessage("Course created successfully");
        setTitle("");
        setDescription("");
        setInstructorName("");
      })
      .catch(() => {
        setMessage("Error creating course");
      });
  };

  return (
    <div>
      <h2>Create Course</h2>

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Course Title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          required
        />

        <input
          type="text"
          placeholder="Instructor Name"
          value={instructorName}
          onChange={(e) => setInstructorName(e.target.value)}
          required
        />

        <textarea
          placeholder="Course Description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          required
        />

        <button type="submit">Create Course</button>
      </form>

      {message && <p>{message}</p>}
    </div>
  );
}

export default CreateCourse;
