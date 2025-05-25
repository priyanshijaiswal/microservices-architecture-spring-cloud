// src/App.js
import React, { useEffect } from 'react';
import { useMsal, useIsAuthenticated } from '@azure/msal-react';
import { loginRequest } from './authConfig';
import EmployeeComponent from './component/EmployeeComponent';

function App() {
  const { instance, inProgress } = useMsal();
  const isAuthenticated = useIsAuthenticated();

  useEffect(() => {
    const doLogin = async () => {
      if (inProgress !== "none") return; // wait until MSAL is ready

      const accounts = instance.getAllAccounts();
      if (accounts.length === 0) {
        await instance.loginRedirect(loginRequest); // safe to call now
      } else {
        try {
          const response = await instance.acquireTokenSilent({
            ...loginRequest,
            account: accounts[0],
          });
          sessionStorage.setItem("accessToken", response.accessToken);
          console.log("The token is: " + response.accessToken); // Using string concatenation
          console.log(`The token is: ${response.accessToken}`);
        } catch (err) {
          console.error("Token acquisition failed, redirecting", err);
          instance.loginRedirect(loginRequest);
        }
      }
    };

    doLogin();
  }, [instance, inProgress]);

  return (
    <div className="container">
      {isAuthenticated ? (
        <EmployeeComponent />
      ) : (
        <p>Redirecting to Microsoft Login...</p>
      )}
    </div>
  );
}

export default App;
