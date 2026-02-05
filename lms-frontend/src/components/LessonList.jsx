import { markLessonCompleted } from "../api/progressApi";

function LessonList({ lessons }) {
  const userId = 1; // temporary hardcoded user

  const handleComplete = (lessonId) => {
    markLessonCompleted(userId, lessonId)
      .then(() => alert("Lesson completed"))
      .catch(() => alert("Error updating progress"));
  };

  return (
    <div>
      <h3>Lessons</h3>
      {lessons.map((lesson) => (
        <div key={lesson.id}>
          <p>{lesson.title}</p>
          <button onClick={() => handleComplete(lesson.id)}>
            Mark as Completed
          </button>
        </div>
      ))}
    </div>
  );
}

export default LessonList;
