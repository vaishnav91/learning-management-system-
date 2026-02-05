import api from "./axiosConfig";

export const markLessonCompleted = (userId, lessonId) =>
  api.post(`/progress/${userId}/${lessonId}`);

export const getUserProgress = (userId) =>
  api.get(`/progress/user/${userId}`);
