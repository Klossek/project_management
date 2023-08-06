/* eslint-disable react/prop-types */
import { createContext, useContext, useReducer } from "react";

const EmployeesContext = createContext(null);

const EmployeesDispatchContext = createContext(null);

export function EmployeesProvider({ children }) {
  const [employees, dispatch] = useReducer(employeesReducer, []);

  return (
    <EmployeesContext.Provider value={employees}>
      <EmployeesDispatchContext.Provider value={dispatch}>
        {children}
      </EmployeesDispatchContext.Provider>
    </EmployeesContext.Provider>
  );
}

export function useEmployees() {
  return useContext(EmployeesContext);
}

export function useEmployeesDispatch() {
  return useContext(EmployeesDispatchContext);
}

function employeesReducer(employees, action) {
  switch (action.type) {
    case "added": {
      console.log("add", action);
      return [
        ...employees, action.employee
      ];
    }
    case "changed": {
      return employees.map((e) => {
        if (e.id === action.employee.id) {
          return action.employee;
        } else {
          return e;
        }
      });
    }
    case "loaded": {

      return action.employees;
    }

    default: {
      throw Error("Unknown action: " + action.type);
    }
  }
}
