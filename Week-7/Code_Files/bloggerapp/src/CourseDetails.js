import React from 'react';

function CourseDetails({ show }) {
  const courses = [
    { id: 1, name: "ReactJS Basics", duration: "4 weeks" },
    { id: 2, name: "Advanced JavaScript", duration: "6 weeks" }
  ];

  return (
    show && ( 
      <div>
        <h2>Courses</h2>
        <ul>
          {courses.map(course => (
            <li key={course.id}>
              {course.name} - {course.duration}
            </li>
          ))}
        </ul>
      </div>
    )
  );
}

export default CourseDetails;
