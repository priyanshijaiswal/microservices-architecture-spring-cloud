export const msalConfig = {
  auth: {
    clientId: "edbd2f5f-74b4-4614-b8f9-1aca5cb9fe35",
    authority: "https://login.microsoftonline.com/1c4c0d85-a423-4bc4-afe9-8ed0a9420439",
    redirectUri: "http://localhost:3000"
  },
  cache: {
    cacheLocation: "localStorage",
    storeAuthStateInCookie: false
  }
};
export const loginRequest = {
  scopes: ["openid", "profile", "email"]
};
