import axios from "axios";
export default axios.create({
  baseURL: "http://localhost:7600/api/v1/customers",
  headers: {
    "Content-type": "application/json"
  }
});