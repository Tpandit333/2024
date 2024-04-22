const express = require("express");
const app = express();
const cors = require("cors"); // Import the cors package

app.use(cors());

const response = [
    {
        name: "Prayag",
        email: "manish@gmail.com",
        phone: "8078676890"
    },
    {
        name: "Pranav",
        email: "pranav.jdh@gmail.com",
        phone: "8078676890",
    },
    {
        name: "Akashu",
        email: "aku11@gmail.com",
        phone: "8078676890",

    },
];
app.get("/users", (req, res) => {

    console.log("Response", response);
    res.json(response);
})

app.listen(3000, () => {
    console.log("listening on port 3000");
})