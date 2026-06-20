async function registerUser() {
    
    try {

        const user = {
            name: document.getElementById("name").value,
            email: document.getElementById("email").value,
            password: document.getElementById("password").value,
            year: document.getElementById("year").value,
            careerGoal: document.getElementById("careerGoal").value
        };

if (
    !user.name ||
    !user.email ||
    !user.password ||
    !user.year ||
    !user.careerGoal
) {
    alert("Please fill all fields");
    return;
}   
        const response = await fetch(
            "/api/auth/register",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(user)
            }
        );

        if (!response.ok) {
            throw new Error("Registration failed");
        }
        
        const data = await response.json();

        console.log(data);

        localStorage.setItem("userId", data.id);

        alert("User Registered: " + data.name);

        window.location.href = "profile.html";
    } catch (error) {

        console.error(error);
        alert("Registration Failed");
    }
}
function getUserId() {
    return localStorage.getItem("userId");
}
async function loadResume() {

    const userId = getUserId();

    const response =
        await fetch(`/api/auth/resume/analyze/${userId}`);

    const data = await response.text();

    const box = document.getElementById("resume");

    box.innerText = data;

    box.style.display = "block";
}

async function loadDsa() {

    const userId = getUserId();

    const response =
        await fetch(`/api/auth/dsa-plan/${userId}`);

    const data = await response.text();

    const box = document.getElementById("dsa");

    box.innerText = data;

    box.style.display = "block";
}

async function loadInterview() {

    const userId = getUserId();

    const response =
        await fetch(`/api/auth/interview/${userId}`);

    const data = await response.text();

    const box = document.getElementById("interview");

    box.innerText = data;

    box.style.display = "block";
}

async function loadCareer() {

    const userId = getUserId();

    const roadmapBox =
        document.getElementById("career");

        roadmapBox.innerHTML = `
        Generating Your AI Career Roadmap...
        
        Analyzing:
        Academic Year
        Career Goal
        Skills
        Current Level
        
        Please wait...
        `;

    try {

        const response =
            await fetch(`/api/auth/career-roadmap/${userId}`);

        const data = await response.text();

        roadmapBox.innerText = data;

    } catch (error) {

        roadmapBox.innerText =
            "❌ Failed to generate roadmap. Please try again.";

        console.error(error);
    }
}
async function loadUserName() {

    const userId = getUserId();

    const response =
        await fetch(`/api/auth/users/${userId}`);

    const user = await response.json();

    document.getElementById("welcomeName")
            .innerText = user.name;
}
window.onload = function() {

    const page =
        window.location.pathname;

    if (page.includes("dashboard.html")) {
        loadUserName();
    }

    if (page.includes("resume.html")) {
        loadResume();
    }

    if (page.includes("dsa.html")) {
        loadDsa();
    }

    if (page.includes("interview.html")) {
        loadInterview();
    }

    if (page.includes("roadmap.html")) {
        loadCareer();
    }
}
async function saveProfile() {

    try {

        const profile = {

            userId: localStorage.getItem("userId"),

            skills:
                document.getElementById("skills").value,

            targetCompanies:
                document.getElementById("targetCompanies").value,

            dailyStudyHours:
                document.getElementById("dailyStudyHours").value,

            currentLevel:
                document.getElementById("currentLevel").value
        };

        const response = await fetch(
            "/api/auth/profile",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(profile)
            }
        );

        if (!response.ok) {
            throw new Error("Profile save failed");
        }

        alert("Profile Saved Successfully");

        window.location.href = "dashboard.html";

    } catch (error) {

        console.error(error);
        alert("Failed to save profile");
    }
};
function logout() {

    localStorage.removeItem("userId");

    window.location.href = "index.html";
}
async function loginUser() {

    try {

        const loginData = {

            email:
                document.getElementById("loginEmail").value,

            password:
                document.getElementById("loginPassword").value
        };

        const response = await fetch(
            "/api/auth/login",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(loginData)
            }
        );

        if (!response.ok) {
            throw new Error("Login Failed");
        }

        const data = await response.json();

        localStorage.setItem("userId", data.id);

        alert("Welcome " + data.name);

        window.location.href = "dashboard.html";

    } catch (error) {

        console.error(error);

        alert("Invalid Email or Password");
    }
}
