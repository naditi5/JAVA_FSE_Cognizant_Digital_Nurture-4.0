import React from 'react';

function UserPage() {
  return (
    <div>
      <h2>Welcome, User!</h2>
      <p>You can view and book flights.</p>
      <ul>
        <li>Flight 101: Delhi to Mumbai <button>Book</button></li>
        <li>Flight 202: Mumbai to Bangalore <button>Book</button></li>
        <li>Flight 303: Chennai to Delhi <button>Book</button></li>
      </ul>
    </div>
  );
}

export default UserPage;
