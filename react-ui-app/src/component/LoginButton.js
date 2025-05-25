import React from "react";
import { useMsal } from "@azure/msal-react";
import { loginRequest } from "../auth/loginRequest";

export const LoginButton = () => {
  const { instance } = useMsal();

  const handleLogin = () => {
    instance.loginRedirect(loginRequest);
  };

  return <button onClick={handleLogin}>Login</button>;
};
