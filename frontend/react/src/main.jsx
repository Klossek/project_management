import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
import './index.css';
import { EmployeesProvider } from './EmployeesContext.jsx';

ReactDOM.createRoot(document.getElementById('root')).render(

  <React.StrictMode>
    <EmployeesProvider>
      <App />
    </EmployeesProvider>

  </React.StrictMode>,
);
