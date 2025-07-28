import React from 'react';

function BlogDetails({ show }) {
  const blogs = [
    { id: 1, title: "React Hooks", author: "Dan Abramov" },
    { id: 2, title: "JSX Tips", author: "Sophie Alpert" }
  ];

  return (
    show ? (
      <div>
        <h2>Blog Posts</h2>
        <ul>
          {blogs.map(blog => (
            <li key={blog.id}>
              <strong>{blog.title}</strong> by {blog.author}
            </li>
          ))}
        </ul>
      </div>
    ) : null 
  );
}

export default BlogDetails;
